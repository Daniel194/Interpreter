package ro.doc.repository.document;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.doc.websocket.broadcaster.DocumentBroadcaster;

import java.util.Observable;
import java.util.Observer;

@Component
public class DocumentRepositoryObserver implements Observer {
    @Autowired
    private DocumentBroadcaster broadcaster;


    @Override
    public void update(Observable o, Object arg) {
        DocumentRepository repo = (DocumentRepository) o;
        this.broadcaster.broadcast(repo.getAll());
    }
}