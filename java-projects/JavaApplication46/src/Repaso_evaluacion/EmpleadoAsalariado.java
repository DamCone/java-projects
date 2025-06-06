/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Repaso_evaluacion;

/**
 *
 * @author : EVA MARÍA GÓMEZ ABAD
 */
// Subclase EmpleadoAsalariado
class EmpleadoAsalariado extends Empleado {
    private double salarioMensual;

    public EmpleadoAsalariado(String nombre, String id, double salarioMensual) throws EmpleadoInvalidoException {
        super(nombre, id);
        if (salarioMensual <= 0) {
            throw new EmpleadoInvalidoException("El salario mensual debe ser mayor que 0.");
        }
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalario() {
        return Math.round(salarioMensual * 100) / 100.0; // Redondeo a 2 decimales
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Asalariado [Nombre: " + nombre + ", ID: " + id 
                           + ", Salario Mensual: $" + salarioMensual 
                           + ", Salario Calculado: $" + calcularSalario() + "]");
    }
}