import React,{createElement} from 'react'
import './header.css'
const Header = () => {
  return (
    createElement('h2',{ className: 'headerStyle' },'Zettamine Labs Private Limited')
  )
}

export default Header
