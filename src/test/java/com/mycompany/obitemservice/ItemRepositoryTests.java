package com.mycompany.obitemservice;

import com.mycompany.obitemservice.model.ItemModel;
import com.mycompany.obitemservice.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testSaveItem() {
        // Crée un nouvel item
        ItemModel item = new ItemModel(null, "Test Item", "Description", 100.0, "categoryId1");

        // Sauvegarde l'item dans MongoDB
        ItemModel savedItem = itemRepository.save(item);

        // Vérifie que l'item a été sauvegardé avec succès
        assertNotNull(savedItem.getId());
    }
}
