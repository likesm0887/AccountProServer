package com.accountProServer.AccountProServer.domain.company;

import java.util.Date;

public class Director {
    public Director(String id, String directorNRIC, String directorPassport, String status, String name, Date resignedDate, Date appointedDate) {
        this.id = id;
        this.directorNRIC = directorNRIC;
        this.directorPassport = directorPassport;
        this.status = status;
        this.name = name;
        this.resignedDate = resignedDate;
        this.appointedDate = appointedDate;
    }

    private String id;
    private String directorNRIC;
    private String directorPassport;
    private String status;
    private String name;
    private Date resignedDate;
    private Date appointedDate;
    public String getId() {
        return id;
    }

    public String getDirectorNRIC() {
        return directorNRIC;
    }

    public String getDirectorPassport() {
        return directorPassport;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Date getResignedDate() {
        return resignedDate;
    }

    public Date getAppointedDate() {
        return appointedDate;
    }
}
