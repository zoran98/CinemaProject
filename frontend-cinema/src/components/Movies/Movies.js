import React, { useCallback } from "react";
import { useEffect } from "react";
import { Button, ButtonGroup, Collapse, Form, Table } from "react-bootstrap";
import CinemaAxios from "../../apis/CinemaAxios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const Movies = () => {
  const [movies, setMovies] = useState([]);
  const [search, setSearch] = useState({
    naziv: "",
    zanrovi: "",
    distributer: "",
    zemljaPorekla: "",
    trajanjeOd: "",
    trajanjeDo: "",
    godinaProizvodnjeOd: "",
    godinaProizvodnjeDo: "",
  });
  const [showSearch, setShowSearch] = useState(false);
  const [totalPages, setTotalPages] = useState(0);
  const [pageNo, setPageNo] = useState(0);
  const navigate = useNavigate();

  useEffect(() => {
    getMovies(0);
  }, []);

  const getMovies = (newPageNo) => {
    const conf = {
      params: {
        pageNo: newPageNo,
      },
    };
    if (search.naziv != "") {
      conf.params.naziv = search.naziv;
    }

    if (search.zanrovi != "") {
      conf.params.zanrovi = search.zanrovi;
    }

    if (search.distributer != "") {
      conf.params.distributer = search.distributer;
    }

    if (search.zemljaPorekla != "") {
      conf.params.zemljaPorekla = search.zemljaPorekla;
    }

    if (search.trajanjeOd != "") {
      conf.params.trajanjeOd = search.trajanjeOd;
    }

    if (search.trajanjeDo != "") {
      conf.params.trajanjeDo = search.trajanjeDo;
    }

    if (search.godinaProizvodnjeOd != "") {
      conf.params.godinaProizvodnjeOd = search.godinaProizvodnjeOd;
    }

    if (search.godinaProizvodnjeDo != "") {
      conf.params.godinaProizvodnjeDo = search.godinaProizvodnjeDo;
    }

    CinemaAxios.get("/filmovi", conf)
      .then((res) => {
        console.log(res);
        setPageNo(newPageNo);
        setMovies(res.data);
        setTotalPages(res.headers["total-pages"]);
      })
      .catch((error) => {
        console.log(error);
        alert("Nije uspelo dobavljanje filmova!");
      });
  };

  const doDelete = (movId) => {
    CinemaAxios.delete("/filmovi/" + movId)
      .then((res) => {
        console.log(res);
        
        var nextPage;
        if (pageNo == totalPages - 1 && movies.length == 1) {
          nextPage = pageNo - 1;
        } else {
          nextPage = pageNo;
        }
        getMovies(nextPage);
 //       setMovies((movies)=>movies.filter(movie => movie.id != movId))
      })
      .catch((error) => {
        console.log(error);
        alert("Doslo je do greske prilikom brisanja!");
      });
  };

  const doEdit = (id) => {
    navigate("/movies/edit/" + id);
  };

  const doSearch = () => {
    getMovies(0);
  };

  const searchValueInputChange = (e) => {
    let newSearch = { ...search };

    const name = e.target.name;
    const value = e.target.value;

    newSearch[name] = value;
    setSearch(newSearch);
  };

  const goToAdd = () => {
    navigate("/movies/add");
  };

  const doMovie = (movId) => {
    navigate("/movie/" + movId);
  };

  return (
    <div>
      <h1>Filmovi</h1>
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
            <Form.Label>Naziv</Form.Label>
            <Form.Control
              value={search.naziv}
              name="naziv"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Zanrovi</Form.Label>
            <Form.Control
              value={search.zanrovi}
              name="zanrovi"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Distributer</Form.Label>
            <Form.Control
              value={search.distributer}
              name="distributer"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Zemlja porekla</Form.Label>
            <Form.Control
              value={search.zemljaPorekla}
              name="zemljaPorekla"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Godina proizvodnje od</Form.Label>
            <Form.Control
              value={search.godinaProizvodnjeOd}
              name="godinaProizvodnjeOd"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Godina proizvodnje do</Form.Label>
            <Form.Control
              value={search.godinaProizvodnjeDo}
              name="godinaProizvodnjeDo"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Trajanje od</Form.Label>
            <Form.Control
              value={search.trajanjeOd}
              name="trajanjeOd"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Form.Group>
            <Form.Label>Trajanje do</Form.Label>
            <Form.Control
              value={search.trajanjeDo}
              name="trajanjeDo"
              as="input"
              onChange={(e) => searchValueInputChange(e)}
            ></Form.Control>
          </Form.Group>

          <Button onClick={() => doSearch()}>Pretraga</Button>
        </Form>
      </Collapse>

      <ButtonGroup style={{ marginTop: 25, float: "left" }}>
        <Button style={{ margin: 3, width: 150 }} onClick={() => goToAdd()}>
          Dodaj film
        </Button>
      </ButtonGroup>

      <ButtonGroup style={{ marginTop: 25, float: "right" }}>
        <Button
          style={{ margin: 3, width: 90 }}
          disabled={pageNo == 0}
          onClick={() => getMovies(pageNo - 1)}
        >
          Prethodna
        </Button>
        <Button
          style={{ margin: 3, width: 90 }}
          disabled={pageNo == totalPages - 1}
          onClick={() => getMovies(pageNo + 1)}
        >
          Sledeca
        </Button>
      </ButtonGroup>

      <Table bordered striped style={{ marginTop: 5 }}>
        <thead className="thead-dark">
          <tr>
            <th>Naziv</th>
            <th>Zanrovi</th>
            <th>Trajanje</th>
            <th>Distributer</th>
            <th>Zemlja porekla</th>
            <th>Godina proizvodnje</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {movies.map((mov) => {
            return (
              <tr key={mov.id}>
                <td>{mov.naziv}</td>
                <td>{mov.zanrovi}</td>
                <td>{mov.trajanje}</td>
                <td>{mov.distributer}</td>
                <td>{mov.zemljaPorekla}</td>
                <td>{mov.godinaProizvodnje}</td>
                <td>
                  <Button
                    variant="info"
                    onClick={() => doMovie(mov.id)}
                    style={{ marginLeft: 5 }}
                  >
                    Prikazi film
                  </Button>
                  {window.localStorage["role"] == "ROLE_ADMIN"
                    ? [
                        <Button
                          variant="warning"
                          onClick={() => doDelete(mov.id)}
                          style={{ marginLeft: 5 }}
                        >
                          Obrisi film
                        </Button>,
                        <Button
                          variant="danger"
                          onClick={() => doEdit(mov.id)}
                          style={{ marginLeft: 5 }}
                        >
                          Izmeni film
                        </Button>,
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

export default Movies;
