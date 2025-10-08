package app.domain.entities;

// Entidad que va representar  un procedimiento médico, este podira ser(Examenes,tratamientos o una intervecion del enfermito(paciente)

public class Procedure {
	
	private int id;
	private String name;
	private double cost;
	private boolean requiresSpecialist;
	

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public boolean isRequiresSpecialist() {
		return requiresSpecialist;
	}
	public void setRequiresSpecialist(boolean requiresSpecialist) {
		this.requiresSpecialist = requiresSpecialist;
	}

}
