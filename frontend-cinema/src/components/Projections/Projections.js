import { useEffect, useState } from "react";

import CinemaAxios from "../../apis/CinemaAxios";
import { Button, ButtonGroup, Collapse, Form, Table } from "react-bootstrap";
import { Link, useNavigate } from "react-router-dom";

const Projections = () => {
  const [projections, setProjections] = useState([]);
  const [search, setSearch] = useState({
    filmId: -1,
    datumIVremePrikazivanjaOd: "",
    datumIVremePrikazivanjaDo: "",
    tipProjekcijeId: -1,
    salaId: -1,
    cenaKarteOd: "",
    cenaKarteDo: "",
  });
  const [showSearch, setShowSearch] = useState(false);
  const [totalPages, setTotalPages] = useState(0);
  const [pageNo, setPageNo] = useState(0);
  const navigate = useNavigate();
  const [movies, setMovies] = useState([]);
  const [typeOfProjections, setTypeOfProjections] = useState([]);
  const [hall, setHall] = useState([]);

  useEffect(() => {
    getProjections(0);
    getTypeOfProjections();
    getHalls();
    getMovies();
  }, []);

  const getProjections = (newPageNo) => {
    const conf = {
      params: {
        pageNo: newPageNo,
      },
    };
    if (search.filmId != -1) {
      conf.params.filmId = search.filmId;
    }

    if (search.datumIVremePrikazivanjaOd != "") {
      conf.params.datumIVremePrikazivanjaOd = search.datumIVremePrikazivanjaOd;
    }

    if (search.datumIVremePrikazivanjaDo != "") {
      conf.params.datumIVremePrikazivanjaDo = search.datumIVremePrikazivanjaDo;
    }

    if (search.tipProjekcijeId != -1) {
      conf.params.tipProjekcijeId = search.tipProjekcijeId;
    }

    if (search.salaId != -1) {
      conf.params.salaId = search.salaId;
    }

    if (search.cenaKarteOd != "") {
      conf.params.cenaKarteOd = search.cenaKarteOd;
    }

    if (search.cenaKarteDo != "") {
      conf.params.cenaKarteDo = search.cenaKarteDo;
    }

    CinemaAxios.get("/projekcije", conf)
      .then((res) => {
        console.log(res);
        setPageNo(newPageNo);
        setProjections(res.data);
        setTotalPages(res.headers["total-pages"]);
      })
      .catch((error) => {
        console.log(error);
        alert("Doslo je do greske prilikom dobavljanja projekcija!");
      });
  };

  const getMovies = () => {
    CinemaAxios.get("/filmovi/forProjections")
      .then((res) => {
        console.log(res);
        setMovies(res.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Doslo je do greske prilikom dobavljanja filmova!");
      });
  };

  const getHalls = () => {
    CinemaAxios.get("/sale")
      .then((res) => {
        console.log(res);
        setHall(res.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Doslo je do greske prilikom dobavljanja sala!");
      });
  };

  const getTypeOfProjections = () => {
    CinemaAxios.get("/tipoviProjekcija")
      .then((res) => {
        console.log(res);
        setTypeOfProjections(res.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Doslo je do greske prilikom dobavljanja tipova projekcija!");
      });
  };

  const doDelete = (proId) => {
    CinemaAxios.delete("/projekcije/" + proId)
    .then((res) => {
      console.log(res);
      var nextPage;
      if (pageNo == totalPages - 1 && projections.length == 1) {
        nextPage = pageNo - 1;
      } else {
        nextPage = pageNo;
      }
      getProjections(nextPage);
    })
    .catch((error) => {
      console.log(error);
      alert("Doslo je do greske prilikom brisanja projekcije!");
    });
  };

  const doSearch = () => {
    getProjections(0);
  };

  const searchValueInputChange = (e) => {
    let newSearch = { ...search };

    const name = e.target.name;
    const value = e.target.value;

    newSearch[name] = value;
    setSearch(newSearch);
  };

  const formatDate = (date) => {
    return date.replace("T", " ");
  };

  const goToProjection = (proId) => {
    navigate("/projection/" + proId);
  };

  const goToAdd = () => {
    navigate("/projections/add");
  };

  return (
    <div>
      <h1>Projekcije</h1>

      <Form.Group style={{ marginTop: 35 }}>
        <Form.Check
          type="checkbox"
          label="Show search form"
          onClick={(e) => setShowSearch(e.target.checked)}
        />
      </Form.Group>
      <Collapse in={showSearch}>
        <Form style={{ marginTop: 10 }}>
          <Form.Group>
            <Form.Label>Film</Form.Label>
            <Form.Control
              onChange={(e) => searchValueInputChange(e)}
              name="filmId"
              value={search.filmId}
              as="select"
            >
              <option value={-1}>Odaberi film</option>
              {movies.map((mov) => {
                return (
                  <option value={mov.id} key={mov.id}>
                    {mov.naziv}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Tip projekcije</Form.Label>
            <Form.Control
              onChange={(e) => searchValueInputChange(e)}
              name="tipProjekcijeId"
              value={search.tipProjekcijeId}
              as="select"
            >
              <option value={-1}>Odaberi tip projekcije</option>
              {typeOfProjections.map((top) => {
                return (
                  <option value={top.id} key={top.id}>
                    {top.naziv}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Sala</Form.Label>
            <Form.Control
              onChange={(e) => searchValueInputChange(e)}
              name="salaId"
              value={search.salaId}
              as="select"
            >
              <option value={-1}>Odaberi salu</option>
              {hall.map((hall) => {
                return (
                  <option value={hall.id} key={hall.id}>
                    {hall.naziv}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Datum i vreme prikazivanja od</Form.Label>
            <Form.Control
              value={search.datumIVremePrikazivanjaOd}
              name="datumIVremePrikazivanjaOd"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Datum i vreme prikazivanja do</Form.Label>
            <Form.Control
              value={search.datumIVremePrikazivanjaDo}
              name="datumIVremePrikazivanjaDo"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Cena karte od</Form.Label>
            <Form.Control
              value={search.cenaKarteOd}
              name="cenaKarteOd"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Cena karte do</Form.Label>
            <Form.Control
              value={search.cenaKarteDo}
              name="cenaKarteDo"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Button onClick={() => doSearch()}>Pretraga</Button>
        </Form>
      </Collapse>

      <ButtonGroup style={{ marginTop: 25, float: "left" }}>
        <Button style={{ margin: 3, width: 150 }} onClick={() => goToAdd()}>
          Dodaj projekciju
        </Button>
      </ButtonGroup>

      <ButtonGroup style={{ marginTop: 25, float: "right" }}>
        <Button
          style={{ margin: 3, width: 90 }}
          disabled={pageNo == 0}
          onClick={() => getProjections(pageNo - 1)}
        >
          Prethodna
        </Button>
        <Button
          style={{ margin: 3, width: 90 }}
          disabled={pageNo == totalPages - 1}
          onClick={() => getProjections(pageNo + 1)}
        >
          Sledeca
        </Button>
      </ButtonGroup>

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
                <td>
                  <Link to={"/projection/" + pro.id}>
                    {formatDate(pro.datumIVremePrikazivanja)}
                  </Link>
                </td>
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
                        </Button>,
                        <Button
                          variant="danger"
                          onClick={() => doDelete(pro.id)}
                          style={{ marginLeft: 5 }}
                        >
                          Obrisi projekciju
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
