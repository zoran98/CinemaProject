import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";

const ListOfTickets = () => {

    const [listoftickets, setListoftickets] = useState([]);

    useEffect(() => {
        getTickets();
    }, []);

    const getTickets = () => {
        CinemaAxios.get("/kupljeneKarte")
        .then((res) => {
            console.log(res);
            setListoftickets(res.data);
        })
        .catch((error) => {
            console.log(error);
            alert("Nije uspelo prikazivanje kupljenih karata!");
        })
    };

    return (
        <div>
            <h1>Kupljene karte</h1>
            <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Naziv</th>
            <th>Projekcija</th>
            <th>Tip projekcije</th>
            <th>Sala</th>
            <th>Cena karte</th>
            <th>Sedista</th>
            <th>Ukupna cena karte</th>
          </tr>
        </thead>
        <tbody>
          {listoftickets.map((tic) => {
            return (
              <tr key={tic.id}>
                <td>{tic.nazivFilma}</td>
                <td>{tic.projekcijaDatum}</td>
                <td>{tic.tipProjekcije}</td>
                <td>{tic.sala}</td>
                <td>{tic.cenaKarte}</td>
                <td>{tic.sedista}</td>
                <td>{tic.ukupnaCena}</td>
              </tr>
            );
          })}
        </tbody>
      </Table>
        </div>
    );
};

export default ListOfTickets;

