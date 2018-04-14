package com.gabriel.selecao.model;

import com.gabriel.selecao.enun.StatusCurso;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ {

	public static volatile SingularAttribute<Aluno, String> nomeAluno;
	public static volatile SingularAttribute<Aluno, Curso> curso;
	public static volatile SingularAttribute<Aluno, Long> id;
	public static volatile SingularAttribute<Aluno, Integer> semestre;
	public static volatile SingularAttribute<Aluno, Integer> numeroMatricula;
	public static volatile SingularAttribute<Aluno, StatusCurso> status;

}

