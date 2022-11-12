package it.unibo.mvc.view;


import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdout implements DrawNumberView {

    private static final String NEW_GAME = ": a new game starts!";
    
    @Override
    public void setController(DrawNumberController observer) {
        // TODO Auto-generated method stub
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("Inizia il game");
    }

    @Override
    public void result(DrawResult res) {
        // TODO Auto-generated method stub
        switch (res) {
             case YOURS_HIGH, YOURS_LOW -> {
                 System.out.println(res.getDescription());
                 return;
             }
             case YOU_WON -> System.out.println(res.getDescription() + NEW_GAME);
             case YOU_LOST -> System.out.println(res.getDescription() + NEW_GAME );
             default -> throw new IllegalStateException("Unknown game state");
        }
    } 
}
