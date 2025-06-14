    <nav class="menu">
        <div class="menu-header">
            <button class="menu-toggle" aria-label="Abrir menú">&#9776;</button>
            <a href="/app" class="titulo">Gestor de turnos</a>
        </div>

        <ul class="nav-items">
            <li><a href="/app">Inicio</a></li>
             <li>
                 <a href="#">Ciudadano</a>
                    <ul class="submenu">
                         <li><a href="/app/ciudadanoForm">Nuevo ciudadano</a></li>
                         <li><a href="/app/listaCiudadanos">Lista de ciudadanos</a></li>
                    </ul>
            </li>
            <li>
                <a href="#">Turno</a>
                <ul class="submenu">
                    <li><a href="/app/turnoForm">Nuevo Turno</a></li>
                    <li><a href="/app/listaTurnos">Lista de turnos</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <script>
        const toggle = document.querySelector('.menu-toggle');
        const navItems = document.querySelector('.nav-items');
        toggle.addEventListener('click', () => {
            navItems.classList.toggle('show');
        });
    </script>