package org.example.practice_14.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.practice_14.GameAuthor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class GameAuthorController {
    private final List<GameAuthor> authors = new ArrayList<>();

    @PostMapping
    public void createAuthor(@RequestBody GameAuthor author) {
        authors.add(author);
    }

    @DeleteMapping("/{index}")
    public void deleteAuthor(@PathVariable int index) {
        if (index >= 0 && index < authors.size()) {
            authors.remove(index);
        }
    }

    @GetMapping
    public List<GameAuthor> getAllAuthors() {
        return authors;
    }
}