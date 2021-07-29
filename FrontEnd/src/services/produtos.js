import { http } from './config'

export default	{

	salvar:(produto)=>{
		return http.post('/',produto);
  },
    
	atualizar:(produto)=>{
		return http.put('/' + produto.id,produto);
  },

  listar:()=>{
		return http.get('/');
  },

  buscarPorNome:(nome)=>{
	return http.get('/byName?nome='+nome);
},
    
	apagar:(produto)=>{
		return http.delete('/'+ produto.id);
	}
}