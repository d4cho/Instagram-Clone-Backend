package io.daniel.models;

import java.util.List;

public class FullComments {

	List<FullComment> fullComments;

	public FullComments() {

	}

	public FullComments(List<FullComment> fullComments) {
		super();
		this.fullComments = fullComments;
	}

	public List<FullComment> getFullComments() {
		return fullComments;
	}

	public void setFullComments(List<FullComment> fullComments) {
		this.fullComments = fullComments;
	}

}
