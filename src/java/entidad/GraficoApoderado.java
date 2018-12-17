/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author Vito
 */
public class GraficoApoderado {
    private int cantPagadaContrato; 
    private int cantPendienteContrato; 
    private int cantPagadaPersonal; 
    private int cantPendientePersonal; 
    private int cantEventosContrato; 
    private int cantPagosAceptados; 
    private int cantPagosPendientes; 

    public GraficoApoderado() {
    }

    public GraficoApoderado(int cantPagadaContrato, int cantPendienteContrato, int cantPagadaPersonal, int cantPendientePersonal, int cantEventosContrato, int cantPagosAceptados, int cantPagosPendientes) {
        this.cantPagadaContrato = cantPagadaContrato;
        this.cantPendienteContrato = cantPendienteContrato;
        this.cantPagadaPersonal = cantPagadaPersonal;
        this.cantPendientePersonal = cantPendientePersonal;
        this.cantEventosContrato = cantEventosContrato;
        this.cantPagosAceptados = cantPagosAceptados;
        this.cantPagosPendientes = cantPagosPendientes;
    }

    public int getCantPagadaContrato() {
        return cantPagadaContrato;
    }

    public void setCantPagadaContrato(int cantPagadaContrato) {
        this.cantPagadaContrato = cantPagadaContrato;
    }

    public int getCantPendienteContrato() {
        return cantPendienteContrato;
    }

    public void setCantPendienteContrato(int cantPendienteContrato) {
        this.cantPendienteContrato = cantPendienteContrato;
    }

    public int getCantPagadaPersonal() {
        return cantPagadaPersonal;
    }

    public void setCantPagadaPersonal(int cantPagadaPersonal) {
        this.cantPagadaPersonal = cantPagadaPersonal;
    }

    public int getCantPendientePersonal() {
        return cantPendientePersonal;
    }

    public void setCantPendientePersonal(int cantPendientePersonal) {
        this.cantPendientePersonal = cantPendientePersonal;
    }

    public int getCantEventosContrato() {
        return cantEventosContrato;
    }

    public void setCantEventosContrato(int cantEventosContrato) {
        this.cantEventosContrato = cantEventosContrato;
    }

    public int getCantPagosAceptados() {
        return cantPagosAceptados;
    }

    public void setCantPagosAceptados(int cantPagosAceptados) {
        this.cantPagosAceptados = cantPagosAceptados;
    }

    public int getCantPagosPendientes() {
        return cantPagosPendientes;
    }

    public void setCantPagosPendientes(int cantPagosPendientes) {
        this.cantPagosPendientes = cantPagosPendientes;
    }
    
    
}
