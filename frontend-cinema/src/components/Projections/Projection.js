import React, { useEffect, useState } from "react";
import { Button, ButtonGroup, Table } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const Projection = () => {
  const [projection, setProjection] = useState({});
  const navigate = useNavigate();
  const routeParams = useParams();

  useEffect(() => {
    getProjection();
  }, []);

  const getProjection = () => {
    CinemaAxios.get("/projekcije/" + routeParams.id)
      .then((res) => {
        console.log(res);
        setProjection(res.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Doslo je do greske prilikom dobavljanja projekcije!");
      });
  };

  const goToProjections = () => {
    navigate("/projections");
  };

  // const date = (date) => {
  //   return date.replace("T", " ");
  // };s

  return (
    <div>
      <ButtonGroup style={{ marginTop: 25, float: "left" }}>
        <Button
          style={{ margin: 3, width: 150 }}
          onClick={() => goToProjections()}
        >
          Projekcije
        </Button>
      </ButtonGroup>

      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Film</th>
            <th>Tip Projekcije</th>
            <th>Sala</th>
            <th>Datum i vreme prikazivanja</th>
            <th>Cena karte</th>
          </tr>
        </thead>
        <tbody>
          <tr key={projection.id}>
            <td>{projection.filmNaziv}</td>
            <td>{projection.tipProjekcijeNaziv}</td>
            <td>{projection.salaNaziv}</td>
            <td>{projection.datumIVremePrikazivanja}</td>
            <td>{projection.cenaKarte}</td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
};

export default Projection;
