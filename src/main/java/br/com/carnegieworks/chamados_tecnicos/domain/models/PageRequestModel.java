package br.com.carnegieworks.chamados_tecnicos.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestModel {
	private int page;
	private int size;
}
