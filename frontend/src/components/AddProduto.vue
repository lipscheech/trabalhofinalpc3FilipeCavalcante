<template>
    <div class="submitform">
        <div v-if="!submitted">
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" id="nome" required v-model="produto.nome" name="nome">
            </div>
            <div class="form-group">
                <label for="descricao">Descrição</label>
                <input type="text" class="form-control" id="descricao" required v-model="produto.descricao" name="descricao">
            </div>
            <div class="form-group">
                <label for="fabricante">Fabricante</label>
                <input type="text" class="form-control" id="fabricante" required v-model="produto.fabricante" name="fabricante">
            </div>

            <button v-on:click="SalvarProduto" class="btn btn-success">Salvar</button>
        </div>
        <div v-else>
            <h4>Salvo com sucesso.</h4>
            <button class="btn btn-success" v-on:click="novoProduto">Adicionar</button>
        </div>
    </div>
</template>

<script>
import http from "../http-common";

export default {
    name: "add-produto",
    data(){
        return {
            produto: {
                id: 0,
                nome: "",
                descricao: "",
                fabricante: "",
                ativo: false
            },
            submitted: false
        };
    },
    methods: {
        salvarProduto(){
            var data = {
                nome: this.produto.nome,
                descricao: this.produto.descricao,
                fabricante: this.produto.fabricante
            };
            http.post("/produto", data).then(response => {
                this.produto.id = response.data.id;
                //console.log(response.data);
            })
            /*.catch(e => {
                //console.log(e);
            });*/

            this.submitted = true;
        },
        novoProduto(){
            this.submitted = false;
            this.produto = {};
        }
    }
};
</script>

<style>
.submitform{
    max-width: 300px;
    margin: auto;
}
</style>