package net.mcreator.butchery.init;

public class ButcheryModScreens {
    static final int PLACEHOLDER_MEATGRINDERGUI = 0;
    static final int PLACEHOLDER_FREEZERINVENTORY = 0;
    static final int PLACEHOLDER_TAXIDERMYSTATIONGUI = 0;
    static final int PLACEHOLDER_PESTLEANDMOTARGUI = 0;

    public static interface ScreenAccessor {
        public void updateMenuState(int var1, String var2, Object var3);
    }
}

