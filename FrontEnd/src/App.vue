<template>
  <div id="app">

    <div class="container">

       <div class="p-3">
        <div class="main-header default-background p-3">
            <div>
               <button class="btn btn-success mx-2" data-bs-toggle="modal" data-bs-target="#productModal">Novo</button>
                <button class="btn btn-danger">Excluir</button>
            </div>
        </div>

        <div class="main-table mt-2">
            <div class="table-header d-flex d-flex justify-content-between p-3 default-background">
                <div class="table-header-title">
                    <h4>Gerenciar produtos- Geovani Xavier</h4>
                </div>
                <div class="table-header-search">
                    <form class="d-flex">
                        <input class="form-control me-1" type="search" placeholder="Nome do produto" aria-label="Search">
                        <button class="btn btn-success" type="submit">
                          Pesquisar
                        </button>
                    </form>
                </div>

            </div>
      
            <table class="table" id="table">
                <thead>
                    <tr class="default-background table-tr">
                        <th scope="col"><input type="checkbox" onClick="toggle(this)" /><br/></th>
                        <th scope="col">CÓDIGO</th>
                        <th scope="col">NOME</th>
                        <th scope="col">PREÇO</th>
                        <th scope="col">CATEGORIA</th>
                        <th scope="col">STATUS</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                     <tr v-for="produto of produtos" :key="produto.id">
                     <td><input type="checkbox" name="foo" value="bar1"><br/></td>
            <td>{{ produto.id }} </td>
            <td>{{ produto.nome }} </td>
            <td>{{ produto.preco }} </td>
            <td>{{ produto.categoria }} </td>
            <td>{{ produto.status }} </td>
          
          <td class="butoes"> 
              <button @click="editar(produto)" data-bs-toggle="modal" data-bs-target="#productModal" class="btn btn-success btn-circle"><i class="material-icons">create</i></button>
              <button @click="loadDeleteModal(produto)" data-bs-toggle="modal" data-bs-target="#productModalDelete" class="btn btn-warning btn-circle mx-2"><i class="material-icons">delete_sweep</i></button>
            </td>
          </tr>
            </tbody>
            </table>
          </div>

        <div class="modal fade" id="productModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Detalhe do produto - Geovani Xavier</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                           <form @submit.prevent="salvar">
                            <div class="mb-3">
                                <label for="recipient-name" class="col-form-label">Nome</label>
                                 <input type="text" id="recipient-name" class="form-control" placeholder="Nome" v-model="produto.nome" >
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Descrição</label>
                                <textarea class="form-control" placeholder="Descrição" id="message-text" v-model="produto.descricao"></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Status</label>
                                <select class="form-select"  id="produto-status" aria-label="Default select example" v-model="produto.status">
                                  <option selected>Selecione</option>
                                  <option value="EMESTOQUE">EMESTOQUE</option>
                                  <option value="SEMESTOQUE">SEMESTOQUE</option>
                                  <option value="BAIXOESTOQUE">BAIXOESTOQUE</option>
                                </select>
                            </div>
                             <label for="message-text" class="col-form-label">categoria</label>
                            <div class="mb-3">
                               <div style="margin-right: 120px" class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="CATEGORIA1" v-model="produto.categoria">
                                    <label class="form-check-label" for="inlineRadio1">CATEGORIA1</label>
                               </div>
                               <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="CATEGORIA2" v-model="produto.categoria">
                                    <label class="form-check-label" for="inlineRadio2">CATEGORIA2</label>
                               </div>
                            </div>
                             <div class="mb-3">
                             <div style="margin-right: 120px" class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="CATEGORIA3"  v-model="produto.categoria">
                                    <label class="form-check-label" for="inlineRadio1">CATEGORIA3</label>
                               </div>
                                  <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="CATEGORIA4" v-model="produto.categoria">
                                    <label class="form-check-label" for="inlineRadio2">CATEGORIA4</label>
                               </div>
                            </div>
                            <div class="mb-3 row ">
                                <div class="col">
                                    <label for="exampleInputEmail1" class="form-label">Preço</label>
                                    <input type="text" class="form-control" id="produto-preco" v-model="produto.preco">
                                </div>
                                <div class="col">
                                    <label for="exampleInputEmail1" class="form-label">Quantidade</label>
                                    <input type="text" class="form-control" id="produto-quantidade" v-model="produto.quantidade">
                                </div>
                            </div>
                            <div class="modal-footer">
                           <button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-outline-primary" data-bs-dismiss="modal">Salvar</button>
                         </div>
                        </form>
                    </div> 
                </div>
            </div>
        </div>
    </div>
   <div class="modal fade" id="productModalDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Excluir</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                     <form @submit.prevent="remover">
                     <div>
                         <h5 style="float: left">  <i class="material-icons">warning</i> Você realmente deseja excluir o <label for="uName">{{ produto.nome }}</label> </h5> 

                         <input type="text" id="uName" v-model="produto.nome" hidden>
                          


                         <input style="width:30px; float: right" type="text" class="form-control" id="input-quantidade" v-model="produto.id" hidden>
                    </div>
                    <div class="modal-footer" style="clear:both">
                           <button type="button" class="btn btn-outline-primary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-outline-primary" data-bs-dismiss="modal">Sim<i class="material-icons left"></i></button>
                     </div>
                    </form> 
                    </div>
                </div>
            </div>
        </div>
  </div>
 </div>
</template>

<script>
import Produto from './services/produtos'
export default {
 name: 'app',
 data(){
    return{
      produto: {
        id: '',
        nome: '',
        descricao: '',
        preco: '',
        categoria: '',
        quantidade: '',
        status: '' 
      },
      produtos: [],
      errors: []
    }

  },
  mounted(){
    this.listar()
  },
  methods:{

    listar(){
      Produto.listar().then(resposta => {
        this.produtos = resposta.data
      }).catch(e => {
        console.log(e)
      })
    },
    salvar(){
      if(!this.produto.id){
        Produto.salvar(this.produto).then(resposta => {
          this.produto = resposta.data
          alert('Cadastrado com sucesso!')
          this.listar()
          this.clear()
          this.errors = {}
        }).catch(e => {
          this.errors = e.response.data.errors
        })
      }else{
        Produto.atualizar(this.produto).then(resposta => {
          this.produto = resposta.data
          this.errors = resposta.errors
          alert('Atualizado com sucesso!')
          this.listar()
          this.clear()
        }).catch(e => {
          this.errors = e.response.data.errors
        })
      }
    },
    clear(){
          this.produto.id = ''
          this.produto.nome = ''
          this.produto.descricao = ''
          this.produto.categoria = ''
          this.produto.preco = ''
          this.produto.quantidade = ''
          this.produto.status = ''
    },
    editar(produto){
    this.produto = produto
    },

     buscarPorNome(){
      Produto.buscarPorNome().then(resposta => {
        this.produtos = resposta.data
      }).catch(e => {
        console.log(e)
      })
    },
    loadDeleteModal(produto){
    this.produto = produto
    },

    remover(){
        Produto.apagar(this.produto).then(resposta => { 
          this.listar()
          this.clear()
          this.errors = resposta.data
        }).catch(e => {
          this.errors = e.response.data.errors
        })
    }
  }
}
</script>

<style>
.main-header {
    height: 80px;
    display: flex;
    justify-content: start;
    align-items: center;
}

.default-background {
    background: #E8E8E8;
    border: 1px solid #E0E0E0;
}

.table-tr {
    height: 60px;
    align-items: center;
}

.table-tr>th {
    border-bottom-width: 0px!important;
}

.table-buttons {
    text-align: center;
    width: 40px;
    height: 40px;
    border-radius: 50%;
}
.btn-circle {
  width: 35px;
  height: 35px;
  text-align: center;
  padding: 4px;
  font-size: 12px;
  line-height: 1.428571429;
  border-radius: 20px;
}
.btn-circle.btn-lg {
  width: 50px;
  height: 50px;
  padding: 10px 16px;
  font-size: 18px;
  line-height: 1.33;
  border-radius: 25px;
}
.btn-circle.btn-xl {
  width: 70px;
  height: 70px;
  padding: 10px 16px;
  font-size: 24px;
  line-height: 1.33;
  border-radius: 35px;
}
</style>