package app.domain.model;

import app.domain.model.enums.ItemType;

public class Item {

	private Long id;                
    private String itemName;          
    private ItemType typee;           // Enum: MEDICAMENTO, PROCEDIMIENTO...
    private String descripcion;    
    private int cantidad;            // Cantidad si aplica
    
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public ItemType getTypee() {
		return typee;
	}
	public void setTypee(ItemType typee) {
		this.typee = typee;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


}
