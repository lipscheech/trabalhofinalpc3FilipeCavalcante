<template>
    <div v-if="this.produto">
        <h4>Produto</h4>
        <div>
            <label>Nome: </label> {{this.produto.nome}}
        </div>
        <div>
            <label>Descricao: </label> {{this.produto.descricao}}
        </div>
        <div>
            <label>Fabricante: </label> {{this.produto.fabricante}}
        </div>

        <div>
            <label>Ativo: </label> {{this.produto.ativo}}
        </div>
        
        <button v-if="this.produto.ativo" v-on:click="updateAtivo(false)" class="button is-small btn-primary">Inativo</button>
        <button v-else v-on:click="updateAtivo(true)" class="button is-small btn-primary">Ativo</button>
        <button class="button is-small btn-danger" v-on:clock="deleteProduto()">Delete</button>
    </div>
    <div v-else>
        <br/>
        <p>Clique em um produto...</p>
    </div>
</template>

<script>
import http from "../http-common";

export default {
    nome: "produto",
    props: ["produto"],
    methods: {
        updateAtivo(status){
            var data = {
                id: this.produto.id,
                nome: this.produto.nome,
                descricao: this.produto.descricao,
                fabricante: this.produto.fabricante,
                ativo: status
            };
            http.put("/produto/"+this.produto.id, data).then(response => {
                this.produto.ativo = response.data.ativo;
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
        },
        deleteProduto(){
            http.delete("/cliente/"+ this.produto.id).then(response => {
                console.log(response.data);
                this.$emit("refreshData");
                this.$router.push('/');
            })
            .catch(e => {
                console.log(e);
            });
        }
    }    
}
</script>