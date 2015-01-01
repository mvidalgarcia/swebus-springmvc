package impl.miw.presentation.schedule;

public class Schedules {
	private Integer idDepartureSchedule;
	private Integer idReturnSchedule;
	
	public Integer getIdReturnSchedule() {
		return idReturnSchedule;
	}
	public void setIdReturnSchedule(Integer idReturnSchedule) {
		this.idReturnSchedule = idReturnSchedule;
	}
	public Integer getIdDepartureSchedule() {
		return idDepartureSchedule;
	}
	public void setIdDepartureSchedule(Integer idDepartureSchedule) {
		this.idDepartureSchedule = idDepartureSchedule;
	}
	@Override
	public String toString() {
		return "Schedules [idDepartureSchedule=" + idDepartureSchedule
				+ ", idReturnSchedule=" + idReturnSchedule + "]";
	}

}
