package org.serratec.backend.projeto02.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto02.exception.TodoException;
import org.serratec.backend.projeto02.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	 //definindo uma url
//	@Value("${url.serratec}")
//	private String urlSerratec
//	
	
	List<Todo> lista = new ArrayList<>();	
	
	public void adicionar(Todo todo) {
		lista.add(todo);
	}
	
	public List<Todo> listaTodo() {
		return this.lista;
	}
	
	public void atualizar(Integer idTodo, Todo todoApi) {
		//idTodo é a posição do objeto no array
		Todo todoListaSalva = new Todo();
		todoListaSalva = lista.get(idTodo);
		
		todoListaSalva.setId(todoApi.getId());
		todoListaSalva.setDescricao(todoApi.getDescricao());
		todoListaSalva.setTitulo(todoApi.getTitulo());
	}
	
	public void deletar(int idTodo) {
		lista.remove(idTodo);
	}
	
    //aqui a busca será pelo id cadastrado e não pela posição no array
	public Todo buscarPorId(Integer idTodo) throws TodoException {
		Todo todoNoBanco = new Todo();
		for(Todo todo : lista) {
			if(todo.getId().equals(idTodo)) {
				todoNoBanco = todo;
			}
		}
		
		if(todoNoBanco.getId() == null) {
			throw new TodoException(idTodo);
		}
		
		return todoNoBanco;
	}
}
