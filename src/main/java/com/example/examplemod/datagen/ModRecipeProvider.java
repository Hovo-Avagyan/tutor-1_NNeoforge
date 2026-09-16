package com.example.examplemod.datagen;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import com.example.examplemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "TutorialMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.AZURITE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_BLOCK
                ,getSimpleRecipeName(ModBlocks.AZURITE_BLOCK), ExampleMod.MODID + ":" + getSimpleRecipeName(ModBlocks.AZURITE_BLOCK),
                getSimpleRecipeName(ModItems.AZURITE), ExampleMod.MODID + ":" +  getSimpleRecipeName(ModItems.AZURITE));


    }
}
