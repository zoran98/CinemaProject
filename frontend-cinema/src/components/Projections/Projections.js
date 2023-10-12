import { useEffect, useState } from "react";

import CinemaAxios from "../../apis/CinemaAxios";
import { Button, Table } from "react-bootstrap";
import moment from "moment/moment";
import { Link, useNavigate } from "react-router-dom";

const Projections = () => {

    const [projections, setProjections] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getProjections(0);
    }, []);

    const getProjections = () => {
        CinemaAxios.get("/projekcije")
        .then((res) => {
            console.log(res);
            setProjections(res.data);
        })
        .catch((error) => {
            console.log(error);
            alert("Doslo je do greske prilikom dobavljanja projekcija!");
        })
    };

    const formatDate = (date) => {
        let datee = date.replace("T", " ");
        return datee;
    };

    // const link = (id) => {
    //     navigate("/movie/" + id);
    // }

    return (
        <div>
            <h1>Projekcije</h1>
            <Table bordered striped style={{ marginTop: 5 }}>
                <thead className="thead-dark">
                    <tr>
                        <th>Film</th>
                        <th>Datum i vreme prikazivanja</th>
                        <th>Tip Projekcije</th>
                        <th>Sala</th>
                        <th>Cena karte</th>
                    </tr>
                </thead>
                <tbody>
                    {projections.map((pro) => {
                        return (
                            <tr key={pro.id}>
                                <td><Link>{pro.filmNaziv}</Link></td>
                                <td>{formatDate(pro.datumIVremePrikazivanja)}</td>
                                <td>{pro.tipProjekcijeNaziv}</td>
                                <td>{pro.salaNaziv}</td>
                                <td>{pro.cenaKarte}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </Table>
        </div>
    );
};

export default Projections;