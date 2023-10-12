import React from "react";
import { createRoot } from 'react-dom/client';
import {
  Route,
  Link,
  HashRouter as Router,
  Routes
} from "react-router-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import { Container, Navbar, Nav, Button } from "react-bootstrap";
import Login from "./components/Login/Login";
import { logout } from "./services/auth";
import Movies from "./components/Movies/Movies";
import AddMovie from "./components/Movies/AddMovie";
import Movie from "./components/Movies/Movie";
import EditMovie from "./components/Movies/EditMovie";
import Projections from "./components/Projections/Projections";

const App = () => {
    return (
      <div>
        <Router>
          <Navbar bg="dark" variant="dark" expand>
            <Navbar.Brand as={Link} to="/">
              JWD
            </Navbar.Brand>
            {/*className="mr-auto" podesi ovu grupu Nav Link-ova da se "rasire" sto je vise moguce,
            i zbog toga je dugme Log in/Log out skroz sa leve strane*/}
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/movies">
                Filmovi
              </Nav.Link>
              <Nav.Link as={Link} to="/projections">
                Projekcije
              </Nav.Link>
            </Nav>

            {window.localStorage['jwt'] ? 
                <Button onClick = {()=>logout()}>Log out</Button> :
                <Nav.Link as={Link} to="/login">Log in</Nav.Link>
            }
          </Navbar>

          <Container style={{marginTop:25}}>
            <Routes>
              <Route path="/" element={<Home/>} />
              <Route path="/login" element={<Login/>}/>
              <Route path="/movies" element={<Movies/>}/>
              <Route path="/movies/add" element={<AddMovie/>}/>
              <Route path="/movie/:id" element={<Movie/>}/>
              <Route path="/movies/edit/:id" element={<EditMovie/>}/>
              <Route path="/projections" element={<Projections/>}/>
              <Route path="*" element={<NotFound/>} />
            </Routes>
          </Container>
        </Router>
      </div>
    );
}

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App/>,
)
