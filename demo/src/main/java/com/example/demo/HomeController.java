package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.RegistroDTO;
import com.example.demo.DTO.ReporteDTO;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // FORMULARIO (GET)
    
    @GetMapping("/levantar-reporte")
    public String mostrarFormularioReporte(Model model) {
        model.addAttribute("reporte", new ReporteDTO());
        return "levantar-reporte";
    }

    
    // FORMULARIO (POST)
    
    @PostMapping("/levantar-reporte")
    public String guardarReporte(@ModelAttribute("reporte") ReporteDTO reporte, Model model) {

        System.out.println("=== REPORTE RECIBIDO ===");
        System.out.println("Boleta: " + reporte.getBoleta());
        System.out.println("Salón: " + reporte.getSalon());
        System.out.println("Fecha: " + reporte.getFecha());
        System.out.println("Hora: " + reporte.getHora());
        System.out.println("Título: " + reporte.getTitulo());
        System.out.println("Descripción: " + reporte.getDescripcion());
        System.out.println("Prioridad: " + reporte.getPrioridad());

        model.addAttribute("mensaje", "Reporte enviado correctamente.");
        return "levantar-reporte";
    }


    @GetMapping("/registro")
public String mostrarRegistro(Model model) {
    model.addAttribute("registro", new RegistroDTO());
    return "registro";
}

@PostMapping("/registro")
public String procesarRegistro(@ModelAttribute RegistroDTO registro, Model model) {

    System.out.println("Nuevo Registro:");
    System.out.println("Nombre: " + registro.getNombre());
    System.out.println("Correo: " + registro.getCorreo());
    System.out.println("Rol: " + registro.getRol());

    // Validaciones y guardado en BD van aquí

    model.addAttribute("mensaje", "Cuenta creada con éxito.");
    return "registro";
}


@GetMapping("/login")
public String login() {
    return "login";
}


}
