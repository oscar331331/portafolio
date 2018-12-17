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
public class GraficoEncargado {
    private int cantFaltanteContrato;
    private int cantDineroEventos;
    private int cantDineroCuotas;
    
    private int cantEventosAceptados;
    private int cantEventosPendientes;
    
    private int cantPagosRealizados;
    private int cantCuotasPendiente;
    private int cantCuotasPagadas;

    public GraficoEncargado() {
    }

    public GraficoEncargado(int cantFaltanteContrato, int cantDineroEventos, int cantDineroCuotas, int cantEventosAceptados, int cantEventosPendientes, int cantPagosRealizados, int cantCuotasPendiente, int cantCuotasPagadas) {
        this.cantFaltanteContrato = cantFaltanteContrato;
        this.cantDineroEventos = cantDineroEventos;
        this.cantDineroCuotas = cantDineroCuotas;
        this.cantEventosAceptados = cantEventosAceptados;
        this.cantEventosPendientes = cantEventosPendientes;
        this.cantPagosRealizados = cantPagosRealizados;
        this.cantCuotasPendiente = cantCuotasPendiente;
        this.cantCuotasPagadas = cantCuotasPagadas;
    }

    public int getCantFaltanteContrato() {
        return cantFaltanteContrato;
    }

    public void setCantFaltanteContrato(int cantFaltanteContrato) {
        this.cantFaltanteContrato = cantFaltanteContrato;
    }

    public int getCantDineroEventos() {
        return cantDineroEventos;
    }

    public void setCantDineroEventos(int cantDineroEventos) {
        this.cantDineroEventos = cantDineroEventos;
    }

    public int getCantDineroCuotas() {
        return cantDineroCuotas;
    }

    public void setCantDineroCuotas(int cantDineroCuotas) {
        this.cantDineroCuotas = cantDineroCuotas;
    }

    public int getCantEventosAceptados() {
        return cantEventosAceptados;
    }

    public void setCantEventosAceptados(int cantEventosAceptados) {
        this.cantEventosAceptados = cantEventosAceptados;
    }

    public int getCantEventosPendientes() {
        return cantEventosPendientes;
    }

    public void setCantEventosPendientes(int cantEventosPendientes) {
        this.cantEventosPendientes = cantEventosPendientes;
    }

    public int getCantPagosRealizados() {
        return cantPagosRealizados;
    }

    public void setCantPagosRealizados(int cantPagosRealizados) {
        this.cantPagosRealizados = cantPagosRealizados;
    }

    public int getCantCuotasPendiente() {
        return cantCuotasPendiente;
    }

    public void setCantCuotasPendiente(int cantCuotasPendiente) {
        this.cantCuotasPendiente = cantCuotasPendiente;
    }

    public int getCantCuotasPagadas() {
        return cantCuotasPagadas;
    }

    public void setCantCuotasPagadas(int cantCuotasPagadas) {
        this.cantCuotasPagadas = cantCuotasPagadas;
    }
    
    
    
    
}
