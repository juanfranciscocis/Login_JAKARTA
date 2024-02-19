package com.example;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

/**
 *
 * @author Leonard
 */
@Named
@RequestScoped
public class PlayersBean implements Serializable{

    List<Players> data = new ArrayList<>();
    final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public PlayersBean() {
        data.add(new Players("NOVAK DJOKOVIC", (byte) 26, "Belgrade, Serbia"));
        data.add(new Players("RAFAEL NADAL", (byte) 27, "Manacor, Mallorca, Spain"));
        data.add(new Players("TOMAS BERDYCH", (byte) 28, "Valasske Mezirici, Czech"));
        data.add(new Players("STANISLAS WAWRINKA", (byte) 28, "Lausanne, Switzerland"));

    }

    public List<Players> getData() {
        return data;
    }

    public void setData(List<Players> data) {
        this.data = data;
    }

}
