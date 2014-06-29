package com.spengilley.activityfragmentmvp;


class Modules {

    private Modules() {
        // No instances
    }


    static Object[] list(App ngswApp) {
        return new Object[]{
                new AppModule(ngswApp),
        };
    }

}
