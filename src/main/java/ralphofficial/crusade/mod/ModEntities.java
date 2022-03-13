package ralphofficial.crusade.mod;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ralphofficial.crusade.mod.entities.DynamiteEntity;

public class ModEntities {

    //Creates the entity type for Dynamite
    public static final EntityType<DynamiteEntity> DynamiteEntityType = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MainClass.MOD_ID, "dynamite"),
            FabricEntityTypeBuilder.<DynamiteEntity>create(SpawnGroup.MISC, DynamiteEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    public static void entityRegistry() {

        //

    }

}
