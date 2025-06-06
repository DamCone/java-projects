/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Repaso_evaluacion;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */
// Subclase EmpleadoPorHoras
class EmpleadoPorHoras extends Empleado {
    private double horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHoras(String nombre, String id, double horasTrabajadas, double tarifaPorHora) throws EmpleadoInvalidoException {
        super(nombre, id);
        if (horasTrabajadas < 0 || tarifaPorHora <= 0) {
            throw new EmpleadoInvalidoException("Las horas trabajadas o la tarifa por hora no son válidas.");
        }
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return Math.round(horasTrabajadas * tarifaPorHora * 100) / 100.0; // Redondeo a 2 decimales
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Por Horas [Nombre: " + nombre + ", ID: " + id 
                           + ", Horas Trabajadas: " + horasTrabajadas 
                           + ", Tarifa Por Hora: " + tarifaPorHora 
                           + ", Salario: ?" + calcularSalario() + "]");
    }
}