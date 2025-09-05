package app.domain.model;

public class DiagnosticAid {
	private Long id;
    private String name;
    private String description;
    private float cost;
    private boolean requiresEspecialist;
    private Long idEspecialty;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean isRequiresEspecialist() {
		return requiresEspecialist;
	}
	public void setRequiresEspecialist(boolean requiresEspecialist) {
		this.requiresEspecialist = requiresEspecialist;
	}
	public Long getIdEspecialty() {
		return idEspecialty;
	}
	public void setIdEspecialty(Long idEspecialty) {
		this.idEspecialty = idEspecialty;
	}
	public boolean isActivo() {
        return requiresEspecialist;
    }

    public void setActivo(boolean activo) {
        this.requiresEspecialist = activo;
    }
    
    
   

}
