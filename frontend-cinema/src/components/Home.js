import React from 'react'
import cinema from '../../src/images/CINEMA.jpg';

class Home extends React.Component {
  render() {
    return <div>
      <h1>Bioskop</h1>
      <img src={cinema} className='rounded' alt='Cinema' width='1100' height='550'></img>
    </div>
    
  }
}

export default Home;