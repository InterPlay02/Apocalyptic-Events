package interplay.apocalypticevents.item;

import net.minecraft.world.item.MapItem;
import org.jetbrains.annotations.NotNull;

public class Newspaper extends MapItem {
    public Newspaper(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull Object getRenderPropertiesInternal() {
        return super.getRenderPropertiesInternal();
    }

    @Override
    public boolean isComplex() {
        return true;
    }


}
