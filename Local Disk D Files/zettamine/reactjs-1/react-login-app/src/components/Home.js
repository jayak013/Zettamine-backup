import React from 'react'
import ViewCardL from './ViewCardL'
import ViewCardR from './ViewCardR'

const Home = () => {
  return (
    <div className='d-flex justify-content-between rounded-5'>
      <ViewCardL/>
      <ViewCardR />
    </div>
  )
}

export default Home
