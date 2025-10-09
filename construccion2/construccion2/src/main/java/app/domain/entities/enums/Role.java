package app.domain.entities.enums;

public enum Role {
	HR,                //únicos autorizados para **crear y eliminar** usuarios(Users y Patients) nuevos en la aplicación* administrar el acceso y los permisos de los usuarios* NO DEBEN PODER VISUALISAR INFORMACION DE PACIENTES, MEDICAMENTOS NI PROCEDIMIENTOS 
	SUPPORT,          //Soporte tecnico: mantiene el sistema melo y da asistencia tecnica
	ADMINISTRATIVE,  // Personal administrativo: gestiona usuarios, facturas, ordenes, reportes
	DOCTOR,         // El Doctor:  atiende a los pacientes, crea ordenes(medicas), realiza diagnosticos y citas
	NURSE,         //Enfermerita: nos va dar apoyo en las consultas, toma los signos vitales y entrega la drogitaaa
                   // registra la visita, busca ordenes y busca pacientes 	

}
