/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Repaso_evaluacion;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */
// Subclase EmpleadoPorComision
class EmpleadoPorComision extends Empleado {
    private double ventasTotales;
    private double porcentajeComision;

    public EmpleadoPorComision(String nombre, String id, double ventasTotales, double porcentajeComision) throws EmpleadoInvalidoException {
        super(nombre, id);
        if (ventasTotales < 0 || porcentajeComision <= 0 || porcentajeComision > 100) {
            throw new EmpleadoInvalidoException("Las ventas totales o el porcentaje de comisión no son válidos.");
        }
        this.ventasTotales = ventasTotales;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalario() {
        return Math.round((ventasTotales * (porcentajeComision / 100)) * 100) / 100.0; // Redondeo a 2 decimales
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Por Comisión [Nombre: " + nombre + ", ID: " + id 
                           + ", Ventas Totales: ?" + ventasTotales 
                           + ", Porcentaje Comisión: " + porcentajeComision 
                           + "%, Salario Calculado: ?" + calcularSalario() + "]");
    }
}
