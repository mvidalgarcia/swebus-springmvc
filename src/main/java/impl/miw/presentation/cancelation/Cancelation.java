package impl.miw.presentation.cancelation;

import javax.validation.constraints.NotNull;

public class Cancelation {
	@NotNull
	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
