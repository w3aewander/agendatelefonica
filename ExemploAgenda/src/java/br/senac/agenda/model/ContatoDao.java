package br.senac.agenda.model;

import br.senac.agenda.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContatoDao {

    public ContatoDao() {
    }

    //Métodos: inserir, alterar, pesquisar, listar, excluir
    public List<Contato> listar() {

        PreparedStatement ps;
        ResultSet rs;
        List<Contato> contatos = new ArrayList<>();

        Connection conexao = ConnectionFactory.getConnection();

        //Comando SQL
        String SQL = "SELECT id, nome, telefone, email FROM contato ORDER BY nome;";

        try {
            ps = conexao.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setEmail(rs.getString("email"));
                
                contatos.add(contato);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contatos;
    }

    public int incluir(Contato contato) {
        PreparedStatement ps;

        Connection conexao = ConnectionFactory.getConnection();

        //Comando SQL
        String SQL = "insert into contato ( nome,telefone,email ) values (?,?,?)";
        int incluidos = 0;
        try {
            ps = conexao.prepareStatement(SQL);

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setString(3, contato.getEmail());

            incluidos = ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return incluidos;
    }

    public int excluir(int contatoId) {

        PreparedStatement ps;

        Connection conexao = ConnectionFactory.getConnection();
 
        int excluidos = 0;
        //Comando SQL
        String SQL = "delete from  contato where id =  ?";

        try {
            ps = conexao.prepareStatement(SQL);

            ps.setInt(1, contatoId);

            excluidos = ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return excluidos;
    }

    public Contato pesquisar(int contatoId) {

        PreparedStatement ps;
        ResultSet rs;

        Connection conexao = ConnectionFactory.getConnection();

        //Comando SQL
        Contato contato = null;

        try {

            String SQL = "select * from   contato where id =  ?";

            ps = conexao.prepareStatement(SQL);

            ps.setInt(1, contatoId);

            rs = ps.executeQuery();
            rs.first();
            
            contato = new Contato(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"),rs.getString("email"));
            
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contato;
    }

    public int modificar(Contato contato) {

PreparedStatement ps;

        Connection conexao = ConnectionFactory.getConnection();

        int modificados = 0;
        
        //Comando SQL
        String SQL = "update contato set nome = ?, telefone = ?, email = ? where id = ? ";

        try {
            ps = conexao.prepareStatement(SQL);

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setString(3, contato.getEmail());
            ps.setInt(4, contato.getId());

            modificados = ps.executeUpdate();

            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return modificados;
    }

}
