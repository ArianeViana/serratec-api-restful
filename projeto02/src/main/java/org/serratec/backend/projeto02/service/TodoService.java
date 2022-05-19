package org.serratec.backend.projeto02.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto02.model.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

//	private List<Todo> todos = Arrays.asList(new Todo(1, "Farmácia", "Comprar remédio"),
//			new Todo(2, "Mercado", "Comprar Leite"),
//			new Todo(3, "Estudar", "Ler capítulo 4"));
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
}
