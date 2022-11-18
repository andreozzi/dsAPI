import logo from '../../assets/img/logo.svg'

import './styles.css'

function Header() {
    return (
        <header>
            <div className="logo-area">
                <img src={logo} alt="DSAPI"/>
                    <h1>DSAPI</h1>
                    <p>Desenvolvido por
                        <a href="https://www.instagram.com/andreozzi._/?next=%2F">@andreozzi._</a>
                    </p>
            </div>
        </header>
    )
}

export default Header
