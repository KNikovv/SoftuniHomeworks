package com.shampoolab.console;

import com.shampoolab.entities.batches.ProductionBatch;
import com.shampoolab.entities.ingredients.*;
import com.shampoolab.entities.labels.ClassicLabel;
import com.shampoolab.entities.shampoos.BasicShampoo;
import com.shampoolab.entities.shampoos.FiftyShades;
import com.shampoolab.entities.shampoos.FreshNuke;
import com.shampoolab.entities.shampoos.PinkPanther;
import com.shampoolab.service.BatchService;
import com.shampoolab.service.IngredientService;
import com.shampoolab.service.LabelService;
import com.shampoolab.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private ShampooService shampooService;
    @Autowired
    private BatchService batchService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private IngredientService ingredientService;

    @Override
    public void run(String... strings) throws Exception {
        BasicIngredient ingredient1 = new Mint();
        BasicIngredient ingredient2 = new Nettle();
        BasicIngredient ingredient3 = new Strawberry();
        BasicIngredient ingredient4 = new Lavender();
        BasicIngredient ingredient5 = new AmoniumChloride();
        this.ingredientService.create(ingredient1);
        this.ingredientService.create(ingredient2);
        this.ingredientService.create(ingredient3);
        this.ingredientService.create(ingredient4);
        this.ingredientService.create(ingredient5);
        ClassicLabel label1 = new ClassicLabel("Fifty Shades", "Tie the aroma");
        ClassicLabel label2 = new ClassicLabel("Fresh Nuke", "Explosively cool");
        ClassicLabel label3 = new ClassicLabel("Pink Panther", "Pleasure in pink");
        this.labelService.create(label1);
        this.labelService.create(label2);
        this.labelService.create(label3);
        ProductionBatch batch = new ProductionBatch();
        batch.setBatchDate(new Date());
        this.batchService.create(batch);
        BasicShampoo s1 = new FiftyShades(label1, batch);
        BasicShampoo s2 = new FreshNuke(label2, batch);
        BasicShampoo s3 = new PinkPanther(label3, batch);
        s1.getIngredients().add(ingredient1);
        s1.getIngredients().add(ingredient2);
        s2.getIngredients().add(ingredient3);
        s2.getIngredients().add(ingredient4);
        s3.getIngredients().add(ingredient5);
        s3.getIngredients().add(ingredient1);
        this.shampooService.create(s1);
        this.shampooService.create(s2);
        this.shampooService.create(s3);
    }
}
