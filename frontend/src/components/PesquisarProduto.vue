<template>
    <div class="searchform">
        <h4>Buscar por fabricante</h4>
        <div class="form-group">
            <input type="text" class="form-control" id="fabricante" required v-model="fabricante" name="fabricante">
        </div>
        <div class="btn-group">
            <button v-on:click="PesquisarProduto" class="btn btn-success">Pesquisar</button>
        </div>
        <ul class="search-result">
            <li v-for="(produto, index) in produtos" :key="index">
                <h6>{{produto.nome}} ({{produto.fabricante}})</h6>
            </li>
        </ul>
    </div>
</template>

<script>
import http from "../http-common"
export default {

    name: "pesquisar-produto",
    data(){
        return {
            fabricante: "",
            produtos: []
        };
    },
    methods: {
        pesquisarProdutos(){
            http.get("/produtos/fabricante/"+ this.fabricante).then(response => {
                this.produtos = response.data;
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
        }
    }
};
</script>

<style>
.searchform {
    max-width: 300px;
    margin: auto;
}
.search-result {
    margin-top: 20px;
    text-align: left;
}
</style>