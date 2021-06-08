/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlalumnosfx;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author mecob
 */
public class Alumnos {

    private SimpleStringProperty nCtrl;
    private SimpleStringProperty nombre;
    private SimpleStringProperty sexo;
    private SimpleStringProperty edad;
    private SimpleStringProperty sem;
    private SimpleStringProperty crApr;
    private SimpleStringProperty carga;
    private SimpleStringProperty promedio;
    private SimpleStringProperty especialidad;
    
    public Alumnos() {
        
    }
    
    public Alumnos(String nCtrl, String nombre, String sexo, String edad, String sem, String crApr, String carga, String promedio, String especialidad) {
        this.nCtrl = new SimpleStringProperty(nCtrl);
        this.nombre = new SimpleStringProperty(nombre);
        this.sexo = new SimpleStringProperty(sexo);
        this.edad = new SimpleStringProperty(edad);
        this.sem = new SimpleStringProperty(sem);
        this.crApr = new SimpleStringProperty(crApr);
        this.carga = new SimpleStringProperty(carga);
        this.promedio = new SimpleStringProperty(promedio);
        this.especialidad = new SimpleStringProperty(especialidad);
    }
    public String getnCtrl() {
        return nCtrl.get();
    }

    public SimpleStringProperty nCtrlProperty() {
        return nCtrl;
    }

    public void setnCtrl(SimpleStringProperty nCtrl) {
        this.nCtrl = nCtrl;
    }
    
    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(SimpleStringProperty nombre) {
        this.nombre = nombre;
    }
    
    public String getSexo() {
        return sexo.get();
    }

    public SimpleStringProperty sexoProperty() {
        return sexo;
    }

    public void setSexo(SimpleStringProperty sexo) {
        this.sexo = sexo;
    }
    
    public String getEdad() {
        return edad.get();
    }

    public SimpleStringProperty edadPorperty() {
        return edad;
    }

    public void setEdad(SimpleStringProperty edad) {
        this.edad = edad;
    }
    
    public String getSem() {
        return sem.get();
    }

    public SimpleStringProperty semProperty() {
        return sem;
    }

    public void setSem(SimpleStringProperty sem) {
        this.sem = sem;
    }
    
    public String getCrApr() {
        return crApr.get();
    }

    public SimpleStringProperty crAprProperty() {
        return crApr;
    }

    public void setCrApr(SimpleStringProperty crApr) {
        this.crApr = crApr;
    }
    
    public String getCarga() {
        return carga.get();
    }
    
    public SimpleStringProperty cargaPorperty() {
        return carga;
    }

    public void setCarga(SimpleStringProperty carga) {
        this.carga = carga;
    }
    
    public String getPromedio() {
        return promedio.get();
    }

    public SimpleStringProperty promedioProperty() {
        return promedio;
    }

    public void setPromedio(SimpleStringProperty promedio) {
        this.promedio = promedio;
    }
    
    public String getEspecialidad() {
        return especialidad.get();
    }

    public SimpleStringProperty especialidadProperty() {
        return especialidad;
    }

    public void setEspecialidad(SimpleStringProperty especialidad) {
        this.especialidad = especialidad;
    }

    
    
    
 
    
    
}