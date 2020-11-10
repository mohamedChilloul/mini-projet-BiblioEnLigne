package com.mini.cqrscommandapi.api;

import com.mini.cqrscoreapi.commands.CatalogueCreationCommand;
import com.mini.cqrscoreapi.commands.LivreCreationCommand;
import com.mini.cqrscoreapi.commands.RemoveLivreCommand;
import com.mini.cqrscoreapi.dto.CatalogueDTO;
import com.mini.cqrscoreapi.dto.LivreDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("command")
public class CommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/catalogue")
    public String createCatalogue(@RequestBody CatalogueDTO catalogueDTO) {
        commandGateway.send(new CatalogueCreationCommand(catalogueDTO.getIdCatalogue(), catalogueDTO.getNomCatalogue()));

        return "catalogue creé avec succes !";
    }

    @PostMapping("/catalogue/{catalogue}/livre")
    public String addLivre(@PathVariable String catalogue, @RequestBody LivreDTO livreDTO) {

        commandGateway.send(new LivreCreationCommand(catalogue, livreDTO.getIsbn(), livreDTO.getTitle()));
        return "livre ajouté avec succes au catalogue";
    }

    @DeleteMapping("/catalogue/{catalogue}/{isbn}")
    public String deleteLivre(@PathVariable String catalogue, @PathVariable String isbn) {
        commandGateway.send(new RemoveLivreCommand(catalogue, isbn));
        return "livre deleted avec succes !";
    }
}
