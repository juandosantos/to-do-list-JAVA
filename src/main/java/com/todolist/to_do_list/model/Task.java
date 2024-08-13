package com.todolist.to_do_list.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Adicionar o Id da tarefa automaticamente
    private String nome; // Ver o nome da Tarefa
    private boolean completo; // Para verificar se a tarefa foi concluida

    public Task (){}

    public Task(String nome){
        this.nome = nome;
        this.completo = false;
    }
 

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isCompleto() {
        return completo;
    }
    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    

}
