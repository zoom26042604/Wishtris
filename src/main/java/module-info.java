module wishtris {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive javafx.media;

    exports com.wishtris;
    exports com.wishtris.game;
    exports com.wishtris.model;
    exports com.wishtris.ui;
}
