/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Infrestructura;

import Capa_Negocio.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author user
 */
public class MongoComunicador implements I_ComunicadorBD {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoComunicador() {
        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.database = mongoClient.getDatabase("TickUpDB");
    }

    @Override
    public List<EventoDTO> extraerEventos() {
        List<EventoDTO> lista = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("eventos");
        
        for (Document doc : collection.find()) {
            lista.add(new EventoDTO(
                doc.getObjectId("_id").toString(),
                doc.getString("nombre"),
                doc.getString("descripcion"),
                doc.getString("fechaHora"),
                doc.getString("estado")
            ));
        }
        return lista;
    }

    @Override
    public List<ZonaDTO> extraerZonasPorEvento(String idEvento) {
        List<ZonaDTO> lista = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("zonas");
        
        for (Document doc : collection.find(eq("idEvento", idEvento))) {
            lista.add(new ZonaDTO(
                doc.getObjectId("_id").toString(),
                doc.getString("nombre"),
                doc.getInteger("capacidadMax"),
                doc.getDouble("precioBase")
            ));
        }
        return lista;
    }

    @Override
    public List<AsientoDTO> extraerAsientosPorZona(String idZona) {
        List<AsientoDTO> lista = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("asientos");
        
        for (Document doc : collection.find(eq("idZona", idZona))) {
            lista.add(new AsientoDTO(
                doc.getObjectId("_id").toString(),
                doc.getString("etiqueta"),
                doc.getString("estado")
            ));
        }
        return lista;
    }

    @Override
    public boolean actualizarEstadoAsiento(String idAsiento, String nuevoEstado) {
        MongoCollection<Document> collection = database.getCollection("asientos");
        Document actualizacion = new Document("$set", new Document("estado", nuevoEstado));
        var resultado = collection.updateOne(eq("_id", new ObjectId(idAsiento)), actualizacion);
        return resultado.getModifiedCount() > 0;
    }

    @Override
    public boolean guardarReservacion(ReservacionDTO reserva) {
        MongoCollection<Document> collection = database.getCollection("reservaciones");
        Document doc = new Document("_id", reserva.getIdReserva())
                .append("idUsuario", reserva.getIdUsuario())
                .append("fechaHora", reserva.getFechaHora())
                .append("totalPagado", reserva.getTotalPagado())
                .append("estatus", reserva.getEstatus())
                .append("idsAsientos", reserva.getIdsAsientos());
        collection.insertOne(doc);
        return true;
    }

    @Override
    public boolean guardarBoleto(BoletoDTO boleto) {
        MongoCollection<Document> collection = database.getCollection("boletos");
        Document doc = new Document("_id", boleto.getFolio())
                .append("idReserva", boleto.getIdReserva())
                .append("idAsiento", boleto.getIdAsiento())
                .append("estado", boleto.getEstado());
        collection.insertOne(doc);
        return true;
    }
}