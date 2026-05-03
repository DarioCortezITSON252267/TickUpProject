/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Infrestructura;

import Capa_Datos.I_EventoDAO;
import Capa_Negocio.EventoDTO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;


/**
 *
 * @author user
 */
public class Mongo_EventoDAO implements I_EventoDAO {
    private final MongoCollection<Document> coleccion;

    public Mongo_EventoDAO() {
        MongoDatabase db = MongoConnectionManager.getInstance().getDatabase();
        this.coleccion = db.getCollection("eventos");
    }
    @Override
    public List<EventoDTO> obtenerTodos() {
        List<EventoDTO> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            lista.add(documentoADTO(doc));
        }
        return lista;
    }
    @Override
    public EventoDTO obtenerPorId(String idEvento) {
        Document doc = coleccion.find(eq("_id", new org.bson.types.ObjectId(idEvento))).first();
        return (doc != null) ? documentoADTO(doc) : null;
    }

    private EventoDTO documentoADTO(Document doc) {
        return new EventoDTO(
            doc.getObjectId("_id").toString(),
            doc.getString("nombre"),
            doc.getString("descripcion"),
            doc.getString("fechaHora"),
            doc.getString("estado")
        );
    }
    @Override
    public List<EventoDTO> buscarPorNombre(String filtro) {
        return new ArrayList<>();
    }
}