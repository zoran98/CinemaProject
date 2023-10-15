import { useEffect, useState } from "react";

import CinemaAxios from "../../apis/CinemaAxios";
import { Button, Table } from "react-bootstrap";
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
      });
  };

  // const moment = (date) => {
  //     return moment(date, 'DD-MM-YYYY').format();
  // }

  const formatDate = (date) => {
    return date.replace("T", " ");
  };

  const goToProjection = (proId) => {
    navigate("/projection/" + proId);
  };

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
            <th></th>
          </tr>
        </thead>
        <tbody>
          {projections.map((pro) => {
            return (
              <tr key={pro.id}>
                <td>
                  <Link to={"/movie/" + pro.filmDTO.id}>
                    {pro.filmDTO.naziv}
                  </Link>
                </td>
                <td>{formatDate(pro.datumIVremePrikazivanja)}</td>
                <td>{pro.tipProjekcijeNaziv}</td>
                <td>{pro.salaNaziv}</td>
                <td>{pro.cenaKarte}</td>
                <td>
                  {window.localStorage["role"] == "ROLE_ADMIN"
                    ? [
                        <Button
                          variant="warning"
                          onClick={() => goToProjection(pro.id)}
                          style={{ marginLeft: 5 }}
                        >
                          Prikazi projekciju
                        </Button>
                      ]
                    : null}
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    </div>
  );
};

export default Projections;
