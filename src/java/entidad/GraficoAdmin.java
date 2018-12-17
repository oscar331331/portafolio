/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;

/**
 *
 * @author Vito
 */
public class GraficoAdmin implements Serializable {
    private int cantContrato;
    private int cantDineroReunido;
    private int cantAlumnos;
    private int cantEmpleados;
    private int cantApoderados;
    private int cantAdministradores;
    private int cantEncCurso;
    private int cantColegios;
    private int cantUsuarios;
    private int cantPagosRealizados;
    private int cantCuotasPendiente;
    private int cantCuotasPagadas;

    

    public GraficoAdmin() {
        
    }

    public GraficoAdmin(int cantContrato, int cantDineroReunido, int cantAlumnos, int cantEmpleados, int cantApoderados, int cantAdministradores, int cantEncCurso, int cantColegios, int cantUsuarios, int cantPagosRealizados, int cantCuotasPendiente, int cantCuotasPagadas) {
        this.cantContrato = cantContrato;
        this.cantDineroReunido = cantDineroReunido;
        this.cantAlumnos = cantAlumnos;
        this.cantEmpleados = cantEmpleados;
        this.cantApoderados = cantApoderados;
        this.cantAdministradores = cantAdministradores;
        this.cantEncCurso = cantEncCurso;
        this.cantColegios = cantColegios;
        this.cantUsuarios = cantUsuarios;
        this.cantPagosRealizados = cantPagosRealizados;
        this.cantCuotasPendiente = cantCuotasPendiente;
        this.cantCuotasPagadas = cantCuotasPagadas;
    }

    public int getCantContrato() {
        return cantContrato;
    }

    public void setCantContrato(int cantContrato) {
        this.cantContrato = cantContrato;
    }

    public int getCantDineroReunido() {
        return cantDineroReunido;
    }

    public void setCantDineroReunido(int cantDineroReunido) {
        this.cantDineroReunido = cantDineroReunido;
    }

    public int getCantAlumnos() {
        return cantAlumnos;
    }

    public void setCantAlumnos(int cantAlumnos) {
        this.cantAlumnos = cantAlumnos;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public int getCantApoderados() {
        return cantApoderados;
    }

    public void setCantApoderados(int cantApoderados) {
        this.cantApoderados = cantApoderados;
    }

    public int getCantAdministradores() {
        return cantAdministradores;
    }

    public void setCantAdministradores(int cantAdministradores) {
        this.cantAdministradores = cantAdministradores;
    }

    public int getCantEncCurso() {
        return cantEncCurso;
    }

    public void setCantEncCurso(int cantEncCurso) {
        this.cantEncCurso = cantEncCurso;
    }

    public int getCantColegios() {
        return cantColegios;
    }

    public void setCantColegios(int cantColegios) {
        this.cantColegios = cantColegios;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }

    public void setCantUsuarios(int cantUsuarios) {
        this.cantUsuarios = cantUsuarios;
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

    public void setCantCuotasPendiente(int cantCuotas) {
        this.cantCuotasPendiente = cantCuotas;
    }

    public int getCantCuotasPagadas() {
        return cantCuotasPagadas;
    }

    public void setCantCuotasPagadas(int cantCuotasPagadas) {
        this.cantCuotasPagadas = cantCuotasPagadas;
    }
    
    
    
}
